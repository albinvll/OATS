import React, { Component } from 'react';

export class ViewText extends Component {
    componentDidMount(){
        console.log(this.props.location.state.text)
    }
    render(){
        return(
            <>
                {this.props.location?.state?.text ? <p>{this.props.location.state.text}</p> : <></>}
            </>
        )
    }
}