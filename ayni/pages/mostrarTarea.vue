<template>
  <div class="main">
    <ul class="ul-cards">
      <li style="--accent-color: #68afff">
        <div class="icon">
          <i class="fa-solid fa-user" />
        </div>
        <div class="title-1">Ver tarea</div>
        <table id="table" class="flat-table">
          <tbody>
            <tr id="row">
              <th>Nombre</th>
              <th>Descripcion</th>
              <th>Ubicacion</th>
              <th>Fecha</th>
              <th>Estado</th>
              <th>Accion</th>
            </tr>
            <tr id="row-1" v-for="(row,index) in tarea" v-bind:key="index">
              <td>{{tarea[index].nombre}}</td>
              <td>{{tarea[index].descripcion}}</td>
              <td>{{tarea[index].ubicacion}}</td>
              <td>{{tarea[index].fechainicio}}</td>
              <td>{{tarea[index].estado}}</td>
              <td>
                <button role="button" class="button-edit" @click="editar">
                  Editar estado
                </button>
              </td>
            </tr>
          </tbody>
        </table>
        <button type="reset" class="button" @click="volver">Volver</button>
      </li>
    </ul>
  </div>
</template>

<script>
import Vue from "vue";
import axios from "axios";

export default {
  data () {
    return {
        tarea: [{nombre:"Tarea 1",descripcion:"Desc 1",ubicacion:"ubi",fechainicio:"sdaklsdj",estado:"si"}]
    }
  },
  methods: {
    volver() {
      this.$router.push({ path: '/crearTarea'})
    },
    editar()
    {
      var estado = prompt('Ingrese nuevo estado')
      var table = document.getElementById('table')
      this.tarea[0].estado = estado

      //Falta recibir los datos desde la vista de ver emergencia
      
      //Realizar UPDATE en el backend
      this.ActualizarTarea()
    },
    async ActualizarTarea() {
      try {
        let response = await this.$axios.put("http://localhost:8080/tarea/actualizar",this.tarea[0]);
      } catch (error) {
        console.log("error", error);
      }
    }
  }
};
</script>

<style scoped>
@import "@/assets/styles/verTarea.css";
</style>
