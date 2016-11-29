var user = new Vue({
    el: '#user',
    data: {
        user: {
            name: 'anonymous'
        },
        isLoggedIn: false
    },
    methods: {
        loadUser: function () {
            axios.get('/api/accounts/me').then(function(response) {
                console.log('load user', response.data);
                console.log('user', response.data.userAuthentication.details);
                user.user = response.data.userAuthentication.details;
                user.isLoggedIn = true;
            }).catch(function (err) {
                console.error(err);
            })
        }
    }
});
var navigationBar = new Vue({
    el: '#navigation-bar',
    methods: {
        logout: function (event) {
            console.log('logging out');
            event.preventDefault();
            axios.post('/logout',{}).then(function () {
                console.log('logged out');
                user.user = { name: 'anonymous' };
                user.isLoggedIn = false;
            }).catch(function (err) {
                console.error(err);
            })
        }
    }
});

window.onload = function () {
    user.loadUser();
};
