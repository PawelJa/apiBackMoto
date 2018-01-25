
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

            var content = $(".event");

            eventCollection.forEach(function (e, i) {
                content.append("" +
                    "<div class='eventContent'>" +
                    "<div class='eventName'>" +
                    "<a class='list' href='show_event_details.html?eventId="+e.id+"'>" + e.eventName + "</a></div>" +
                    "<div class='eventDate'>" + e.dateStart + " - " + e.dateEnd + "</div>" +
                    "<div class='trackName'>" + e.trackName + "</div>" +
                    "<div class='description'>" + e.description.substring(0, 100) + ' ...' + "</div>");

            })

        })
    }

    getEvents();

})