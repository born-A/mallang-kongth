/* src/main/frontend/src/App.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';

 밑으로 3줄 추가한 내용
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Login from './Login';
import Signup from './Signup';
function App() {
    const [hello, setHello] = useState('')

    useEffect(() => {
      axios.get('/api/hello')
          .then(response => setHello(response.data))
          .catch(error => console.log(error))
    }, []);
    return(

    );
}

export default App;*/


import { BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import Login from './Login';
import Signup from './Signup';

function App() {
    return (
        <div>
                <Routes>
                    <Route path="/" element={<Login />} />
                    <Route path="/Signup" element={<Signup />}/>
                </Routes>
        </div>
    );
}

export default App;






