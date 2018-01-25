$(document).ready(function () {

    var buttonToSend = document.querySelector('#buttonToSend');
    console.log(buttonToSend);
    buttonToSend.addEventListener('click', function () {

        var input = document.getElementById("file");
        var file = input.value.split("\\");
        var fileName = file[file.length - 1];

        var file2 = input.files[0];

        console.log(file2.size)

        console.log(input)
        console.log(file)
        console.log(fileName)
        console.log(file.f)
    })


})
