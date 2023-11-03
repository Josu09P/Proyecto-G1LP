



function eliminarProducto(id) {
    var productId = $(this).data('productid');
    console.log(productId);
    Swal.fire({
        title: "¿Estás seguro?",
        text: "Una vez eliminado, no podrás recuperar este producto.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Sí, eliminarlo",
        cancelButtonText: "Cancelar",
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "administrador/productos/delete/" + id,
                method: "GET", // Ajusta el método HTTP según tus necesidades.
                success: function (res) {
                    console.log(res);
                    Swal.fire("Registro eliminado", "El producto se ha eliminado correctamente.", "success").then((result) => {
                        if (result.isConfirmed) {
                            // Realizar cualquier acción adicional después de la eliminación del producto, como redirigir.
                            location.href = "administrador"; // Ajusta la URL de redirección según tu aplicación.
                        }
                    });
                },
                error: function (error) {
                    console.error("Error al eliminar el registro:", error);
                    Swal.fire("Error al eliminar el registro", {
                        icon: "error",
                    });
                },
            });
        }
    });
}


