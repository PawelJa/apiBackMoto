
$(document).ready(function () {

    function getEvents() {

        console.log("ready")
        //Pobranie danych z endpointy/event
        $.ajax({
            url: "http://localhost:8080/user/"
        }).done(function (user) {
            userDetails = user;
            console.log(userDetails);

            var h4 = $("h4");
            console.log(h4);
            h4[0].innerText='Witaj ' + userDetails.username + " !";

            var avatar = $('.avatar');
            avatar.append("" +
                "<img src='file://" + userDetails.avatar + "' style='max-height: 250px; max-weidth: 250px'/>")
            console.log(avatar)


        })
    }

    getEvents();

})