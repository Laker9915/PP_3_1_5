const url = 'http://localhost:8080/api/users'
const whore_url = 'http://localhost:8080/api/users' //TODO
const t_body = document.getElementById(`tbody`)
const tw_body = document.getElementById('twbody')

async function findAll() {
    let adminPage = await fetch(url)
    let userList = await adminPage.json();
    let users_table = '';
    let whoreList = await fetch(whore_url);
    let whores_table = '';
    for (let user of userList) {
        let roles = [];
        for (let role of user.roles) {
            roles.push(" " + role.name.toString().replaceAll('ROLE_', ''))
        }
        users_table +=
            `<tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.age}</td>
                <td>${user.username}</td>
                <td>${roles}</td>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                        data-target="#editModal" onclick="editModalData(${user.id})">Edit</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" 
                        data-target="#deleteModal" onclick="deleteModalData(${user.id})">Delete</button>
                </td>
            </tr>`
    }
    t_body.innerHTML = users_table;

    for (let whore of whoreList) {
        for (let phones of whore.name) {
            roles.push(" " + role.name.toString().replaceAll('ROLE_', ''))
        }
        whores_table +=
            `<tr>
                <td>${whore.name}</td>
                <td>${whore.name}</td>
                <td>${whore.surname}</td>
                <td>${whore.age}</td>
                <td>${whore.username}</td>
            </tr>`
    }
    tw_body.innerHTML = whores_table;
}

findAll();
