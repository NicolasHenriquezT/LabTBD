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
        <div class="table-container">
            <table class="main-table">
                    <tr v-for="(e, index) in emergencias" :key="index">
                        <td>{{ e.id }}</td>
                        <td>{{ e.name }}</td>
                        <td>{{ e.ubicacion }}</td>
                        <td>
                            <nuxt-link :to="{ name: 'verEmergencia', 
                                              path: '/verEmergencia',
                                              params: { emergencia: e.id }}">
                                <img width="25" height="25" :src="joinLogo" />
                            </nuxt-link>
                        </td>                    
                    </tr>
            </table>
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
import joinLogo from '../static/arrow-basic-ui-svgrepo-com.svg'
export default ({
    data(){
        return {
            userLogeado: {},
            emergencias: [],
            joinLogo,
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
      
      let username = this.$route.params.username;
      this.userLogeado = username;
      this.getEmergencias();
  },
})
</script>

<style>
  @import "@/assets/styles/verEmergencias.css";
</style>