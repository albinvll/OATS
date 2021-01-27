import React, { Component } from 'react';
import { MDBCard, MDBCardBody, MDBInput, MDBIcon, MDBBtn } from 'mdbreact';
import "./register.css"
import axios from 'axios';
import { ToastsContainer, ToastsContainerPosition, ToastsStore } from 'react-toasts';

export class Register extends Component{

    state = {
        radio:1,
        name:"",
        surname:"",
        email:"",
        password:""
    }

    showRegisterForm(){
        return(
            <>
            <div id="register-card-div">
                            <h1>Register</h1>
                <MDBCard className="register-card">
                    <MDBCardBody>
                        <div className="text-center">
                        </div>
                        <MDBInput type="text" value={this.state.name} onChange={this.handleNameChange} label="Name:"/>
                        <MDBInput type="text" value={this.state.surname} onChange={this.handleSurnameChange} label="Surname:"/>
                        <MDBInput type="email" value={this.state.email} onChange={this.handleEmailChange} label="Email:"/>
                        <MDBInput type="password" value={this.state.password} onChange={this.handlePasswordChange} label="Password:"/>
                        <div id="subscription-card-div" >
                            <MDBCard  className="subscription-card">
                                <MDBCardBody>
                                    <h2>1 month subscription</h2>
                                    <p className="subscription-card-paragraph">
                                        Get 1 month of access to our services.
                                    </p>

                                    <div className={"subscription-card-radio-button"} >
                                        <MDBInput onClick={this.onClick(1)} checked={this.state.radio===1 ? true : false} type="radio" id="radio1" />
                                    </div>
                                </MDBCardBody>
                            </MDBCard>
                            <MDBCard  className="subscription-card">
                                <MDBCardBody>
                                    <h2>6 month subscription</h2>
                                    <p className="subscription-card-paragraph">
                                        Get 6 months of access to our services.
                                    </p>
                                    <div className={"subscription-card-radio-button"} >
                                        <MDBInput onClick={this.onClick(2)} checked={this.state.radio===2 ? true : false} type="radio" id="radio2" />
                                    </div>
                                </MDBCardBody>
                            </MDBCard>
                            <MDBCard  className="subscription-card">
                                <MDBCardBody>
                                    <h2>12 month subscription</h2>
                                    <p className="subscription-card-paragraph">
                                        Get 1 year of access to our services.
                                    </p>
                                    <div className={"subscription-card-radio-button"} >
                                        <MDBInput onClick={this.onClick(3)} checked={this.state.radio===3 ? true : false} type="radio" id="radio3" />
                                    </div>
                                </MDBCardBody>
                            </MDBCard>
                        </div>
                        <div  className="text-center">
							<button id="register-button" onClick={(e) => this.attemptRegistration(e)}>Register</button>
                            <button id="register-button" onClick={(e) => this.backToLogin(e)}>Back to login</button>
						</div>
                    </MDBCardBody>
                </MDBCard>
                </div>
            </>
        );
    }

    backToLogin(e){
        e.preventDefault();
        this.props.history.push("/logout");
    }

    attemptRegistration = async (event) =>{
        event.preventDefault();
        if(!this.state.email || this.state.email?.length <= 0){
			ToastsStore.error("Please type your email");
			return;
		}
		if(!this.state.password || this.state.password?.length <= 0){
			ToastsStore.error("Please type your password");
			return;
        }
        
        if(!this.state.name || this.state.name?.length <= 0){
			ToastsStore.error("Please type your name");
			return;
		}
		if(!this.state.surname || this.state.surname?.length <= 0){
			ToastsStore.error("Please type your surname");
			return;
		}

        const response = await axios.post("http://localhost:8080/api/login/register",
            {
                id:null,
                emri: this.state.name,
                mbiemri: this.state.surname,
                email: this.state.email,
                password: this.state.password,
                idSubscription: this.state.radio
            }
        );
        if(response){
            this.props.history.push("/login");
        }
    }

    handleNameChange=(event)=>{
		this.setState({name: event.target.value});
	}

	handleSurnameChange=(event)=>{
		this.setState({surname: event.target.value});
	}

    handleEmailChange=(event)=>{
		this.setState({email: event.target.value});
	}

	handlePasswordChange=(event)=>{
        this.setState({password: event.target.value});
	}


    onClick = nr => () => {
    this.setState({
        radio: nr
    });
    }
    render(){
        return(
            <>
                <ToastsContainer store={ToastsStore} position={ToastsContainerPosition.TOP_RIGHT} />
                {this.showRegisterForm()}
            </>
        )
    }
}