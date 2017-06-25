class User {
    constructor() {
        this.reset();
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