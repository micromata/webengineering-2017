import React from "react";

class Authentication extends React.Component {
    render() {
        return (
            <div className="component">
                <h1>Authentication</h1>
                <form>
                    {/*Note that the HTML structure will be changed later when we add Bootstrap/CSS*/}
                    <label>
                        Email
                        <input type="text" name="email"/>
                    </label>
                    <label>
                        Password
                        <input type="password" name="password"/>
                    </label>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        );
    }
}


export default Authentication;