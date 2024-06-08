function generateReport(type) {
  fetch("/generate-report?type=" + type)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok ' + response.statusText);
      }
      return response.json();
    })
    .then(data => {
      Swal.fire({
        title: data.titulo,
        text: data.contenido,
        icon: 'info',
        confirmButtonText: 'OK'
      });
    })
    .catch(error => {
      console.error('Hay problemas en el fetch:', error);
    });
}