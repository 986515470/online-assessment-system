$(".toggle").on("click", function() {
	$(".container").stop().addClass("active");
});

$(".close").on("click", function() {
	$(".container").stop().removeClass("active");
});


function submitLoginForm() {

	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	   $('#username').val(username);
         $('#password').val(password);

	if (username == "" || password == "")
		alert("一卡通或密码不能为空！")

	else {
		var form = document.getElementById('Login');
		form.submit();
	}

}

function submitRegisterForm() {
	var value1 = document.getElementById("password1").value;
	var value2 = document.getElementById("username1").value;
	var value3 = document.getElementById("classes").value;
	var value4 = document.getElementById("name").value;
      $('#username1').val(value2);
        $('#name').val(value4);
          $('#classes').val(value3);
            $('#password1').val(value1);

	var form = document.getElementById('register');
	if (value1 == "" || value2 == "" || value3 == "" || value4 == "")
		alert("不能有空！")
	else {
		form.submit();
		window.location.href="index.html";
	}

}

function identity(val1, val2) {
	if (typeof val1 == typeof val2) {
		if (val1 == val2) {
			return true
		} else {
			return false
		}
	} else {
		return false
	}

}
