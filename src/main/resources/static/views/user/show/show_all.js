
$(document).ready(function () {

    function getUsers() {

        var usersCollection = [];
        console.log("ready")
        //Pobranie danych z endpointy/users
        $.ajax({
            url: "http://localhost:8080/user/all"
        }).done(function (user) {
            usersCollection = user;
            console.log(usersCollection);

            var content = $(".content");

            usersCollection.forEach(function (e, i) {
                content.append("<div id ='" + i + "class='username'><strong>" + e.username + "</strong></div></br>");
            })

        })
    }

    getUsers();

})