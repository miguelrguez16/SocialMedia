"use strict";


$(document).ready( ()=> {
    console.log("READY");


    $("#form").submit((event)=>{
        event.preventDefault();

        var newUser = {
            name: $('input[name="name"]').val(),
            last: $('input[name="last"]').val(),
            email: $('input[name="email"]').val(),
            date: $('input[name="date"]').val(),

        };

        console.log(newUser);

        $.ajax({
            method: "POST",
            url: "api/users",
            data: JSON.stringify(newUser),
            contentType: "application/json",
            beforeSend: function () {
                console.log("Enviando datos ...");
            },
            success: function (response) {
                console.log(response);
            },
            error: function () {
                alert("error");
            },
            timeout: 10000, // tiempo maximo de respuesta
        });

    });
});
