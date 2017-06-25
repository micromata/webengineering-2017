class User {
    constructor() {
        this.email = undefined;
        this.id = -1;
    }
}

// Singleton pattern in ES6.
export default (new User);