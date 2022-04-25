<!-- Please remove this file from your project -->
<template>
  <div class="main">
    <div class="contenedor">
      <div class="title">
        <h1>
          Plataforma Ayni
        </h1>
      </div>
    </div>
    <ul class="ul-cards">
      <li style="--accent-color: #68AFFF">
        <div class="icon">
          <i class="fa-solid fa-user" />
        </div>
        <div class="title">
          Iniciar Sesión
        </div>
        <div class="content">
          <label for="nombre-inicio">Ingrese su nombre</label>
          <input id="nombre-inicio" v-model="inicio_sesion.name" type="text"><br>
          <label for="pass-inicio">Ingrese su contraseña</label>
          <input id="pass-inicio" v-model="inicio_sesion.password" type="password"><br>

          <button type="button" @click="InicioSesion">
            Iniciar Sesión
          </button>
        </div>
      </li>
      <li li style="--accent-color: #FFA44B">
        <div class="icon">
          <i class="fa-solid fa-house" />
        </div>
        <div class="title">
          Registrar Voluntario
        </div>
        <div class="content">
          <label for="nombre-registro">Ingrese su nombre</label>
          <input id="registro" v-model="registro.nombre" type="text"><br>
          <label for="apellido-registro">Ingrese su apellido</label>
          <input id="registro" v-model="registro.apellido" type="text"><br>
          <label for="correo-registro">Ingrese su correo</label>
          <input id="registro" v-model="registro.correo" type="email"><br>
          <label for="pass-registro">Ingrese su contraseña</label>
          <input id="registro" v-model="registro.contraseña" type="password"><br>
          <label for="direccion-registro">Ingrese su direccion</label>
          <input id="registro" v-model="registro.direccion" type="text"><br>
          <label for="rut-registro">Ingrese su RUT</label>
          <input id="registro" v-model="registro.rut" type="text"><br>
          <label for="rut-registro">Ingrese su estado</label>
          <input id="registro" v-model="registro.estado" type="text"><br>
          <button type="button" @click="RegistrarVoluntario">
            Registrar
          </button>
        </div>
      </li>
      <li style="--accent-color: #EF6968">
        <div class="icon">
          <i class="fa-solid fa-wifi" />
        </div>
        <div class="title">
          Registrar Institución
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'MainPage',

  data () {
    return {
      user: {},
      inicio_sesion: {},
      registro: {},
      voluntarios: [],
      instituciones: []
    }
  },
  methods: {
    async getVoluntarios () {
      try {
        const response = await this.$axios.get('http://localhost:8080/voluntarios')
        this.voluntarios = response.data
      } catch (error) {
        return error
      }
    },
    async getInstituciones () {
      try {
        const response = await this.$axios.get('http://localhost:8080/instituciones')
        this.instituciones = response.data
      } catch (error) {
        return error
      }
    },
    InicioSesion () {
      //  Se debe revisar que los datos ingresados esten en la base de datos

      //  Se verifica si es un voluntario
      //  Traemos todos los voluntarios
      this.getVoluntarios()
      this.voluntarios.forEach((voluntario) => {
        //  Si los datos ingresados corresponden a los registrados en la base de datos se le envia a la vista de voluntarios
        if ((this.inicio_sesion.name === (voluntario.nombre + ' ' + voluntario.apellido)) && (this.inicio_sesion.password === voluntario.contraseña)) {
          //  Enviar a vista de voluntarios
          alert('Sesion iniciada como voluntario')
        }
      })
      //  Si no se le reconoce como voluntario es porque quizas es un coordinador
      this.getInstituciones()
      if (this.instituciones) {
        this.instituciones.forEach((institucion) => {
          let coordinadores = institucion.coordinadores
          coordinadores = coordinadores.split(',')
          let contraseñas = institucion.clavesCoordinadores
          contraseñas = contraseñas.split(',')
          for (let i = 0; i < coordinadores.length; i++) {
            if (coordinadores[i] === this.inicio_sesion.name && contraseñas[i] === this.inicio_sesion.password) {
              alert('Sesion iniciada como coordinador')
              break
            }
          }
        })
      }
    },
    async RegistrarVoluntario () {
      //  Se debe verificar que el correo del usuario a registrar no se encuentre ya.
      let flag = 0
      let num = 0
      this.getVoluntarios()
      num = this.voluntarios.length
      this.registro.id = num + 1
      this.voluntarios.forEach((voluntario) => {
        if (voluntario.correo === this.registro.correo) {
          flag = 1
          alert('El correo electronico ya se encuentra registrado')
        }
      })
      if (flag === 0) {
        try {
          await this.$axios
            .post('http://localhost:8080/nuevo-voluntario', this.registro)
            .then(res => res.data)
            .catch(res => res)
        } catch (error) {
          return error
        }
      }
      this.getVoluntarios()
    }
  }
}
</script>

<style>
*:focus {outline:none !important}
body
{
  background: linear-gradient(90deg, #e3ffe7 0%, #d9e7ff 100%);
}
.main
{
  text-align:center;
}
.title
{
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  display: flex;
  justify-content: center;
  font-size: 32px;
  color: black;
}

#nombre-inicio
{
  padding:10px;
  border-radius:5px;
  margin:5px;
}
#pass-inicio
{
  padding:10px;
  border-radius:5px;
  margin: 5px;
}
#registro
{
  padding:10px;
  border-radius:5px;
  margin: 5px;
}
label
{
  display: inline-block;
  width: 200px;
}
ul.ul-cards {
    margin-inline: auto;
    display: flex;
    flex-wrap: wrap;
    gap: 2rem;
    list-style: none;
    justify-content: center;
    margin: 40px;
}
ul.ul-cards>li{
    --bg-color: #F2F2F2;
    --text-color: #333;
    --padding: 1rem;
    --circle-size: 5rem;
    --circle-expand: 1rem;
    --flap-height: 1.25rem;
    --flap-offset: 0.5rem;
    max-width: 15rem;
    margin-top: calc(var(--circle-size) / 2 + var(--circle-expand));
    margin-bottom: var(--flap-offset);
    background-color: var(--bg-color);
    background-image: linear-gradient(to bottom left, transparent 50%, rgba(0 0 0  / .125));
    border-radius: var(--padding);
    padding: var(--padding);

    --bs-rim: inset -0.1rem 0.1rem 0.1rem rgb(255 255 255 / .5);
    --bs-card-spread: 0.25rem;
    --bs-card-color:  rgb(0 0 0 / 0.02);
    --bs-card:
        -0.1rem 0.1rem var(--bs-card-spread) var(--bs-card-color),
        -0.2rem 0.2rem var(--bs-card-spread) var(--bs-card-color),
        -0.3rem 0.3rem var(--bs-card-spread) var(--bs-card-color),
        -0.4rem 0.4rem var(--bs-card-spread) var(--bs-card-color),
        -0.5rem 0.5rem var(--bs-card-spread) var(--bs-card-color),
        -0.6rem 0.6rem var(--bs-card-spread) var(--bs-card-color),
        -0.7rem 0.7rem var(--bs-card-spread) var(--bs-card-color),
        -0.8rem 0.8rem var(--bs-card-spread) var(--bs-card-color),
        -0.9rem 0.9rem var(--bs-card-spread) var(--bs-card-color),
        -1.0rem 1.0rem var(--bs-card-spread) var(--bs-card-color),
        -1.1rem 1.1rem var(--bs-card-spread) var(--bs-card-color),
        -1.2rem 1.2rem var(--bs-card-spread) var(--bs-card-color),
        -1.3rem 1.3rem var(--bs-card-spread) var(--bs-card-color),
        -1.4rem 1.4rem var(--bs-card-spread) var(--bs-card-color),
        -1.5rem 1.5rem var(--bs-card-spread) var(--bs-card-color),
        -1.6rem 1.6rem var(--bs-card-spread) var(--bs-card-color),
        -1.7rem 1.7rem var(--bs-card-spread) var(--bs-card-color),
        -1.8rem 1.8rem var(--bs-card-spread) var(--bs-card-color),
        -1.9rem 1.9rem var(--bs-card-spread) var(--bs-card-color);
    box-shadow: var(--bs-rim), var(--bs-card);
    display: grid;
  grid-template-rows: max-content max-content auto ;
    justify-items: center;
    text-align: center;
    gap: 0.75rem;
    position: relative;
}
ul.ul-cards>li>.icon{
    width: var(--circle-size);
    margin-top: calc(var(--circle-size) / -2 - var(--padding));
    aspect-ratio: 1;
    background-color: var(--bg-color);
    justify-self: center;
    border-radius: 50%;
    display: grid;
    place-items: center;
    box-shadow:var(--bs-rim), -0.1rem 0.1rem 0.25rem rgb(0 0 0 / .25);
}
ul.ul-cards>li>.icon>i{
    font-size: calc(var(--circle-size) / 3);
    color: var(--accent-color);
}
ul.ul-cards>li>.title{
    margin-top: 0.5rem;
    color: var(--accent-color);
    font-weight: 700;
}
ul.ul-cards>li>.content{
    font-size: 1rem;
    margin-bottom: 1rem;
    color: var(--text-color)
}
ul.ul-cards>li::before, ul>li::after{
    content: "";
    position: absolute;
}
ul.ul-cards>li::before{
    top: calc(var(--circle-size) / -2 - var(--circle-expand));
    width: calc(var(--circle-size) * 1 + var(--circle-expand) * 2);
    height: calc(100% + var(--circle-size) / 2 + var(--padding) + var(--flap-offset)) ;
    background-color: var(--accent-color);
    background-image: linear-gradient( transparent 50%, rgb(0 0 0 / .25) 0);
    border-top-left-radius: calc(var(--circle-size) / 2 + var(--circle-expand));
    border-top-right-radius: calc(var(--circle-size) / 2 + var(--circle-expand));
    clip-path: polygon(
      0 0,
      100% 0,
      100% calc(100% - var(--flap-offset)),
      calc(100% - var(--flap-offset)) 100%,
      var(--flap-offset) 100%,
      0 calc(100% - var(--flap-offset))
    );
    z-index: -1;
}
ul.ul-cards>li::after{
    width: calc(var(--circle-size) * 1 + var(--circle-expand) * 2 - var(--flap-offset) * 2);
    height: var(--flap-height);
    bottom: calc(var(--flap-offset) * -1);
    border-top-left-radius: var(--flap-height);
    border-top-right-radius: var(--flap-height);
    background-color: var(--accent-color);
}

/*  */

*, *::before, *::after {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

@import url('https://fonts.googleapis.com/css?family=Monoton');
html,
body {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: "Monoton", Helvetica, sans-serif;
  background: #AB3428;
  letter-spacing: 5px;
}

h1 {
  margin-top: 100px;
  margin-bottom: 0px;
  display: inline;
  font-size: 30px;
  text-transform: uppercase;
  color: #F49E4C;
  @media (min-width: 700px) {
    font-size: 9vw;
  }
  @media (min-width: 1400px) {
    font-size: 150px;
  }
}

@supports (-webkit-background-clip: text) {
h1 {
  color: transparent;
  background: linear-gradient(7deg, #F5EE9E 50%, #F49E4C 0);
  -webkit-background-clip: text;
}
}
</style>
