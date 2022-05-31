"use strict";



async function fetchAsync (url) {
    let response = await fetch(url);
    //console.log(data.at(4));
    return await response.json();
}


function getListaUsers(){
    fetchAsync("http://localhost:8080/api/users")
        .then((data) =>{
            for (let i = 0; i < data.length; i++) {
                const user = data.at(i);
                console.log(user.name);
                $("#tabla tbody").append("<tr>"
                    + "<td>" + user.name + "</td>"
                    + "<td>" + user.email + "</td>"
                    + "<td>" + user.username + "</td>"
                    +"</tr>");
            }
        });
}

$(document).ready(() => {
    console.log("READY");

    getListaUsers();
    var p1 = document.querySelector("#password");
    var p2 = document.querySelector("#password1");
    var spanError = document.querySelector("#spanError");

    $("#form").submit((event) => {
        event.preventDefault();
        console.log(` 1:  ${p1.value} =? ${p2.value}`)
        if(p1.value != p2.value){
            spanError.textContent="Error: passwords not match"
            p1.style = "color:red";
            p2.style = "color:red";
        }
        else {
            let newUser = {
                name: $('input[name="name"]').val(),
                email: $('input[name="email"]').val(),
                date: new Date(),
                username: $('input[name="username"]').val(),
                password: $('input[name="password"]').val()
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
                error: function () {
                    alert("error");
                },
                timeout: 10000, // tiempo maximo de respuesta
            });



            getListaUsers();
        }


    });
});