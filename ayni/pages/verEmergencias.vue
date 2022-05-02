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
      <li style="--accent-color: #68afff">
        <div class="icon">
          <i class="fa-solid fa-user" />
        </div>
        <div class="title-1"> Emergencias</div>
        <table id="table" class="flat-table">
          <tbody>
            <tr id="row-1" v-for="(e,index) in emergencias" v-bind:key="index">
              <nuxt-link :to="{ name: 'verEmergencia',
                                 path: '/verEmergencia',
                                params: { emergencia: e.id}}">
                    <td>{{ e.id}}</td>
                    <td>{{ e.nombre}}</td>
                    <td>{{ e.ubicacion}}</td>
                    <td>{{ e.fecha}}</td>
              </nuxt-link>
            </tr>
          </tbody>
        </table>
      </li>
    </ul>
  </div>
</template>
<script>

export default ({
    data(){
        return {
            userLogeado: {},
            emergencias: {},
        }
    },
    methods: {
        async getEmergencias(){
           try {
            console.log(this.emergencias)
            let response = await this.$axios.get('http://localhost:8080/emergencias');
            this.emergencias = response.data;
            console.log(this.emergencias)
            console.log(response) 
            } catch (error) {
                console.log('error', error);
            } 
        },
    },
    //Función que se ejecuta al cargar el componente
  created: async function() {
      this.getEmergencias();
      let username = this.$route.params.username;
      this.userLogeado = username;
  },
})
</script>

<style>
  @import "@/assets/styles/verEmergencias.css";
</style>