
function addAppointment(){

    let id=$('#exampleFormControlInput0').val();
    let email=$('#exampleFormControlInput1').val();
    let faculty=$('#exampleFormControlInput2').val();
    let lecturer=$('#exampleFormControlInput3').val();
    let message=$('#exampleFormControlInput4').val();
    let count=$('#exampleFormControlInput5').val();

    $.ajax({
        method:"POST",
        contentType:"application/json",
        url:"http://localhost:8080/api/v1/appointment/addAppointment",
        async:true,
        data:JSON.stringify({
            "id":id,
            "email":email,
            "faculty":faculty,
            "lecturer":lecturer,
            "message":message,
            "count":count,
            "status":"Not Confirmed"
        }),
        success: function (data) {
            alert("saved")

        },
        error: function (xhr, exception) {
            alert("Your earlier appointment is being processed ‼️")
        }
    })



}
function editAppointment(){

    let id=$('#exampleFormControlInput0').val();
    let email=$('#exampleFormControlInput1').val();
    let faculty=$('#exampleFormControlInput2').val();
    let lecturer=$('#exampleFormControlInput3').val();
    let message=$('#exampleFormControlInput4').val();
    let count=$('#exampleFormControlInput5').val();

    $.ajax({
        method:"PUT",
        contentType:"application/json",
        url:"http://localhost:8080/api/v1/appointment/editAppointment",
        async:true,
        data:JSON.stringify({
            "id":id,
            "email":email,
            "faculty":faculty,
            "lecturer":lecturer,
            "message":message,
            "count":count
        }),
        success: function (data) {
            alert("Updated")

        },
        error: function (xhr, exception) {
            alert("Error")
        }
    })

}
function deleteAppointment(){
    let id=$('#exampleFormControlInput0').val();

    $.ajax({
        method:"DELETE",
        url:"http://localhost:8080/api/v1/appointment/deleteAppointment/"+id,
        async:true,
        success: function (data) {
            alert("Deleted")

        },
        error: function (xhr, exception) {
            alert("Not a Registered Student")
        }
    })

}
function getAppointment(){
    let stuId=$('#exampleFormControlInput0').val();



    $.ajax({
        method:"GET",
        url:"http://localhost:8080/api/v1/appointment/getAllEmployees",
        async:true,
        success: function (data) {
            if (data.code==="00"){
            $('#empTable').empty();
            for (let apt of data.content){
            let id=apt.id
            let email=apt.email
            let faculty=apt.faculty
            let lecturer=apt.lecturer
            let message=apt.message
            let count=apt.count
            let date=apt.date
            let status=apt.status

            if(stuId==id){
                var row=`<tr><td>${id}</td><td>${email}</td><td>${faculty}</td><td>${message}</td><td>${count}</td><td>${date}</td><td>${status}</td></tr>`;
                $('#lecTable').append(row);
            }
            }
            }
        },
        error: function (xhr, exception) {
            alert("Error")
        }
    })

}
$(document).ready(function () {
    $(document).on('click', '#empTable tr', function () {
        var col0 = $(this).find('td:eq(0)').text();
        var col1 = $(this).find('td:eq(1)').text();
        var col2 = $(this).find('td:eq(2)').text();
        var col3 = $(this).find('td:eq(3)').text();

        $('#exampleFormControlInput1').val(col0);
        $('#exampleFormControlInput2').val(col1);
        $('#exampleFormControlInput3').val(col2);
        $('#exampleFormControlInput4').val(col3);

    })
})
