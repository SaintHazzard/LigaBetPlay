$(document).ready(function () {
  // Obtener el valor del campo nombre
  var nombre = $("#nombre").val();

  // Realizar la petición AJAX al controlador
  $.post("/ejemplo", { nombre: nombre }, function (data) {
    // Mostrar una alerta con SweetAlert2 con la respuesta del controlador
    Swal.fire({
      title: '¡Respuesta del servidor!',
      text: data,
      icon: 'success',
      confirmButtonText: 'OK'
    });
  });

});