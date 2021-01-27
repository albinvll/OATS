import React, { Component } from 'react';

export class Header extends Component{

    render(){
        return(

            <>
                <div>
                    <button onClick={this.logOut}>
                        Logout
                    </button>
                </div>
            </>
        );
    }
}