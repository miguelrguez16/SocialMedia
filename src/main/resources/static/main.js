"use strict";



async function fetchAsync (url) {
    let response = await fetch(url);
    //console.log(data.at(4));
    return await response.json();
}

$(document).ready(() => {
    console.log("READY");

    fetchAsync("http://localhost:8080/api/users")
        .then((data) =>{
            for (let i = 0; i < data.length; i++) {
                const user = data.at(i);
                console.log(user.name);
                $("#tabla tbody").append("<tr>"
                    + "<td>" + user.name + "</td>"
                    + "<td>" + user.last + "</td>"
                    + "<td>" + user.email + "</td>"

                    +"</tr>");
            }
        })

    $("#form").submit((event) => {
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
            url: "http://localhost:8080/api/users",
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