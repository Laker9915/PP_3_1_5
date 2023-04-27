const form_new = document.forms["formForCreatingNewUser"];
const roles_new = document.querySelector('#roles').selectedOptions;
function handleErrors(error) {
    console.error(error);
    const errorMessage = document.getElementById('error-message');
    errorMessage.textContent = 'Пользователь с таким email\'ом уже существует'
}
form_new.addEventListener("submit", ev => {
    ev.preventDefault();
    let listOfRole = [];
    for (let i = 0; i < roles_new.length; i++) {
        listOfRole.push({
            id: roles_new[i].value,
            name: "ROLE_" + roles_new[i].text
        });
        console.log(listOfRole);
    }
    fetch('/api/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: form_new.firstName.value,
            surname: form_new.lastName.value,
            age: form_new.age.value,
            username: form_new.email.value,
            password: form_new.password.value,
            roles: listOfRole
        })
    }).then(response => {
        if (response.ok) {
            form_new.reset();
            findAll();
            $('#nav-home-tab').click();
        } else {
            handleErrors(response.statusText)
        }

})})

