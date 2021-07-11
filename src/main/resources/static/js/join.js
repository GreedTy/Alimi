function userRegister() {
    alert($("#username").val() + " " + $("#password").val() + " " + $("#phone_number").val() + " " + $("#email").val())
    let account = {
        'username': $("#username").val(),
        'password': $("#password").val(),
        'phoneNumber': $("#phone_number").val(),
        'email': $("#email").val()
    };
    $.ajax({
        url: '/account',
        type: 'post',
        data: {
            'account': account
        },
        success: function(data) {
            alert("welcome Alimi!" + data);
            window.location.replace("http://localhost:8080/group/list");
        },
        error: function(data) {
            alert(data + " Login Your Input is wrong please check your Info");
        }
    })
}