
$(document).ready(function () {

    function getEvents() {

        var eventCollection = [];
        console.log("ready")
        //Pobranie danych z endpointy/event
        $.ajax({
            url: "http://localhost:8080/event/all"
        }).done(function (event) {
            eventCollection = event;
            console.log(eventCollection);

            var content = $(".content");

            eventCollection.forEach(function (e, i) {
                content.append("<div id ='" + i + "class='trackName'>" +
                    "<a href='show_event_details.html?eventId="+e.id+"'>" +
                    "<strong>" + e.trackName + "</strong></a></div></br>");
            })

        })
    }

    getEvents();

})