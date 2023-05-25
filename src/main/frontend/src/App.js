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
//import PetJournalMain from "./components/rearing/PetJournalMain";
import PetRegister from "./Components/petInformation/petRegister";
import HospitalForm from "./Components/rearing/HospitalForm";
import MainPage from "./Components/App/mainPage";
import BoardWrite from "./Components/bbs/boardWrite";
import BoardList from "./Components/bbs/boardList";
import EatingAmount from "./Components/eatAmount/eatAmount";

function App() {
    return (
        <div>
                <Routes>
                    <Route path="/" element={<MainPage />} />
                    <Route path="/Signup" element={<Signup />}/>
                    <Route path="/mainPage" element={<MainPage />}/>
                    <Route path="/petRegister" element={<PetRegister />}/>
                    <Route path="/boardList" element={<BoardList />}/>
                    <Route path="/boardWrite" element={<BoardWrite />}/>
                    <Route path="/eatAmount" element={<EatingAmount />}/>
                </Routes>
        </div>
    );
}

export default App;