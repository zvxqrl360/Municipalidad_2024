                <!-- SCRIPS NUEVOS AGREGADOS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/pdfmake.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.2.7/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.html5.min.js"></script>
        
        <script>
            $(document).ready(function() {
                var tablaCargos = $('#tablaCargos').DataTable({
                    dom: '<"top"lBf>t<"bottom"ip><"clear">',
                    buttons: [
                        {
                            extend: 'excel',
                            text: '<i class="fa fa-file-excel-o"></i> Excel',
                            className: 'btn btn-success',
                            titleAttr: 'Exportar a Excel',
                            title: 'Lista de Cargos', // Cambiar el título del EXCEL aquí
                            exportOptions: {
                                columns: [0, 1, 2]
                            }   
                        },
                        {
                            extend: 'pdfHtml5',
                            text: '<i class="fa fa-file-pdf-o"></i> PDF',
                            className: 'btn btn-danger',
                            titleAttr: 'Exportar a PDF',
                            title: 'Lista de Cargos', // Cambiar el título del PDF aquí
                            exportOptions: {
                                columns: [0, 1, 2]
                            },
                            customize: function(doc) {
                                // Estilos personalizados para el PDF
                                doc.styles.tableHeader.fillColor = '#337ab7';
                                doc.styles.tableHeader.color = '#fff';
                                doc.styles.tableBodyEven.fillColor = '#f2f2f2';
                                doc.styles.tableBodyOdd.fillColor = '#ffffff';

                                // Alineación de las celdas
                                doc.content[1].table.widths = Array(doc.content[1].table.body[0].length + 1).join('*').split('');
                                doc.content[1].table.body.forEach(function(row) {
                                    row.forEach(function(cell, i) {
                                        cell.alignment = (i === 0) ? 'center' : 'center';
                                    });
                                });
                            }
                        }
                    ]
                });

                $('#exportarExcel').on('click', function() {
                    tablaCargos.buttons('.buttons-excel').trigger();
                });

                $('#exportarPDF').on('click', function() {
                    tablaCargos.buttons('.buttons-pdf').trigger();
                });
            });
        </script>