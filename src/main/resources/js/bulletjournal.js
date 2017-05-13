$(document).ready(function () {
    (function () {
        var serverURL = "http://localhost:8080/weekSummary/2017-04-12";
        $.getJSON(serverURL)
            .done(function (data) {
                $.each(data, function (index, item) {
                    var newRowContent = "<tr>" +
                        "<td class='appointments'>" + printAppointments(item) + "</td>" +
                        "<td class='day'>" + printFormattedDate(item) + "</td>" +
                        "<td class='tasks'>" + printTasks(item) + "</td>" +
                        "</tr>";
                    $("#weekOverview tbody").append(newRowContent);
                });
            });
    })();
});

function printAppointments(item) {
    var appointmentStr = '';
    $.each(item.appointments, function (index, appointment) {
        appointmentStr += '<li class="appointment">' + appointment.title + '</li>';
    });
    return appointmentStr;
}

function printFormattedDate(item) {
    return "<h3>" + ($.format.date(new Date(item.day), "ddd<br /><br />D of MMMM <br />yyyy<br />")) + "</h3>";
}

function printTasks(item) {
    var tasksStr = '';
    $.each(item.tasks, function (index, task) {
        tasksStr += '<li class="appointment">' + task.title + '</li>';
    });
    return tasksStr;
}