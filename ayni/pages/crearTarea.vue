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
                <input id="nombre-tarea"  type="text"><br>
                <label for="descripcion">Descripción</label>
                <input id="descripcion" type="text"><br>
                <label for="fechaTarea">Fecha de inicio</label>
                <input id="fechaTarea" type="date"><br>
                <label for="ubicacionTarea">Ubicación</label>
                <input id="ubicacionTarea" type="text"><br>
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
      atributos: [],
      habilidades: [],
      user: {
        selecciones: []
      }
    }
  },
  methods: {
    CrearTarea () {
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
