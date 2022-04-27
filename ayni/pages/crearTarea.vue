<template>
    <div>
      <ul class="ul-cards">
        <li style="--accent-color: #68AFFF">
            <div class="icon">
                <i class="fa-solid fa-user" />
            </div>
            <div class="title">
                Nueva Tarea
            </div>
            <div class="content">
                <label for="nombre-tarea">Nombre de la tarea</label>
                <input id="nombre-tarea" v-model="nuevaTarea.nombre" type="text" ><br>
                <label for="descripcion">Descripción</label>
                <input id="descripcion" v-model="nuevaTarea.descripcion" type="text"><br>
                <label for="fechaTarea">Fecha de inicio</label>
                <input id="fechaTarea" v-model="nuevaTarea.fechainicio" type="date"><br>
                <label for="ubicacionTarea">Ubicación</label>
                <input id="ubicacionTarea" v-model="nuevaTarea.ubicacion" type="text"><br><br>
                <p>Habilidades Requeridas</p><br>
                <div class="form-group form-check" v-for="item in habilidades" v-bind:key="item.id">
                    <label class="form-check-label" :for="item.id">{{item.name}}</label>
                    <input type="checkbox"  v-model="user.selecciones" :id="item.name" :value="item.name"><br>
                </div>
                <button type="button" class="buttonCrearTarea" @click="CrearTarea">
                    Crear Tarea
                </button>
            </div>
        </li>
      </ul>
    </div>
</template>
<script>
export default {
  data () {
    return {
      temp: {},
      nuevaTarea: {},
      atributos: [],
      habilidades: [],
      user: {
        selecciones: []
      }
    }
  },
  methods: {
    async CrearTarea () {
      try {
        let response = await this.$axios.get("http://localhost:8080/tareas");
        this.temp = response.data;
        if(this.nuevaTarea.nombre == null ){
            alert("Debe ingresar un nombre para la tarea");
        }
        else if(this.nuevaTarea.descripcion == null){
            alert("Debe ingresar una descripcion para la tarea");
        }
        else if(this.nuevaTarea.fechainicio == null){
            alert("Debe ingresar un fecha de inicio");
        }
        else if(this.nuevaTarea.ubicacion == null){
            alert("Debe ingresar una ubicacion de la tarea")
        }
        else{
          let lista = ''
          this.nuevaTarea.estado = 'Recien Creada'
          for(let i = 0; i < this.user.selecciones.length; i++){
            lista = lista + ',' + this.user.selecciones[i]
          }
          console.log(lista)
          this.nuevaTarea.listaHabilidades = lista
          try {
            await this.$axios
              .post("http://localhost:8080/nueva-tarea", this.nuevaTarea)
              .then((res) => res.data)
              .catch((res) => res);
          } catch (error) {
            console.log("error", error);
          }
        
        }
      } catch (error) {
        console.log("error", error);
      }
    },
    async getHabilidades () {
      try {
        const response = await this.$axios.get('http://localhost:8080/habilidades')
        this.atributos = response.data
      } catch (error) {
        return error
      }
      this.atributos.forEach((atributo) => {
        this.habilidades.push({ name: atributo.nombre })
      })
      console.log(this.habilidades)
    }
  },
  created: function () {
    this.getHabilidades()
  }
}
</script>

<style>
  @import '@/assets/styles/crearTarea.css';
</style>
