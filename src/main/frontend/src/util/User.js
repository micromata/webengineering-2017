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
}

// Singleton pattern in ES6.
export default (new User);