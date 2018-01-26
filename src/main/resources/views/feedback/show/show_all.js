
$(document).ready(function () {

    function getEvents() {

        var feedbackCollection = [];
        console.log("ready")
        //Pobranie danych z endpointy/event
        $.ajax({
            url: "http://localhost:8080/feedback/all"
        }).done(function (feedback) {
            // feedbackCollection = feedback;
            console.log(feedback);

            var content = $(".content");

            // console.log(feedbackCollection[0].event.eventName)

            feedback.forEach(function (e) {
                content.append("" +
                    "<div class='feedbackContent'>" +
                    "<div class='eventName'>" + e.event.eventName + "</div>" +
                    "<div class='trackName'>" + e.event.trackName + "</div>" +
                    "<div class='username'>" + e.user.username + " / "+ e.dateAdd + "</div>" +
                    "<div class='description'>" + e.description +"</div>" +
                    "</div>");

            })

        })
    }

    getEvents();

})