<template>
    <div class="content">
        <table class="main-table">
            <thead>
                <th> Nombre </th>
                <th> Descripción </th>
                <th> Ubicación </th>
            </thead>
            
        </table>
    </div>
</template>

<script>
export default {

  data () {
    return {
      tareas: [],
      
    }
  },
  methods: {
    async getTareas() {
       try {
        console.log(this.items)
        let response = await this.$axios.get('http://localhost:8080/tareas');
        this.tareas = response.data;
        console.log(this.tareas)
        console.log(response) 
      } catch (error) {
        console.log('error', error);
      }
    },  
    
  },
  created: function ()
  {
    this.getTareas()
  }
}
</script>

<style>
  @import '@/assets/styles/main.css';
</style>
