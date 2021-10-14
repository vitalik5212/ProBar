let validate = () => {
    comparePassword();
}

let comparePassword =  () => {

    let password = document.getElementById('password').value;
    let repass = document.getElementById('repass').value;

    if(!(password===repass)) {
        document.getElementById('password_error').innerText = "Passwords aren't the same";
        document.getElementById('submit').setAttribute('disabled', 'true');
    } else {
        document.getElementById('password_error').innerText = "";
        document.getElementById('submit').removeAttribute('disabled')
    }
}