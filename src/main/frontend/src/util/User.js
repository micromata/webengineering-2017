import axios from "axios";
import Cookies from "universal-cookie";

class User {
    constructor() {
        this.reset();
        const cookies = new Cookies();
        const auth = cookies.get('auth');
        if (auth) {
            this.setCookieCredentials(auth);
        }
    }

    setCookieCredentials(credentials) {
        axios.defaults.headers.common['Authorization'] = `Bearer ${credentials.token}`;
        this.set(credentials.user);
    }

    set(data) {
        this.email = data.email;
        this.id = data.id;
    }

    reset() {
        this.email = undefined;
        this.id = -1;
    }

    isAuthenticated() {
        return this.email && this.id != -1;
    }

    isNotAuthenticated() {
        return !this.isAuthenticated();
    }
}

// Singleton pattern in ES6.
export default (new User);