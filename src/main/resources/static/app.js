

const onHandleListItemClick = async (id) => {
    console.log('click ', id)

    const options = {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: {}
    }
    const response = await fetch(`/todos/${id}`, options)
    const data = await response.json()
    console.log('data', data)
    window.location.reload()
}
const onHandleListItemRightClick = async (id, event) => {
    event.preventDefault();
    const options = {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    };
    const response = await fetch(`/todos/${id}`, options);
    if (response.ok) {
        console.log(`ToDo with ID ${id} has been deleted.`);
        window.location.reload();
    } else {
        console.error(`Failed to delete ToDo with ID ${id}.`);
    }
}
function redirectToUser() {
    var username = document.getElementById('username').value;
    if (username) { // Check if the input is not empty
        window.location.href = '/user/' + encodeURIComponent(username);
    } else {
        alert('Please enter a username.');
    }
}
$(() => {
    console.log('jquery ready')
})