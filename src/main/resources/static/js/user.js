function userRegister() {
   $.ajax({
      url: '/user',
      type: 'post',
      data: {
         'userId': $("#userid").val(),
         'password': $("#password").val()
      },
      success: function(data) {
         alert("success" + data)
         window.location.replace("http://localhost:8080/expose")
      },
      error: function(data) {
         alert("regist fail");
      }
   })
}