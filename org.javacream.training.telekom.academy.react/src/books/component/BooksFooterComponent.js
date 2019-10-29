import React from 'react';
import ClockComponent from '../../util/ClockComponent';
import LogComponent from '../../util/LogComponent';

export function BooksFooterComponent () {
        return (
            <div className='footer'>
                <p >Javacream Training</p>
                <hr />
                <ClockComponent />
                <hr />
                <LogComponent numberOfMessages="3"/>
            </div>
        );    
    }


export default BooksFooterComponent

