import React, {useEffect, useState} from 'react';
import './HospitalForm.css';

import axios, { AxiosResponse } from 'axios';
import apiAxios from "../../apiAxios";

function HospitalForm({ onRecordSubmit }) {
    const baseUrl = "http://localhost:8080";

    const [hospitalName, setHospitalName] = useState([]);
    const [dateOfVisit, setDateOfVisit] = useState([]);
    const [bill, setBill] = useState([]);
    const [imageUrl, setImageUrl] = useState([]);
    const [memo, setMemo] = useState([]);

    useEffect(() => {
        fetch('/hospitalNotes/new')
            .then((response) => {
                return response.json();
                console.log(response.data);

            })
            .then(function (data) {
                setHospitalName(data.hospitalName);
                setDateOfVisit(data.dateOfVisit);
                setBill(data.bill);
                setImageUrl(data.imageUrl);
                setMemo(data.memo);
            });
    }, []);


    // async function getFormDto(){
    //     await axios
    //         .get("/hospitalNotes/new")
    //         .then((response) => {
    //             console.log(response.data);
    //             setHospitalName(response.data.hospitalName);
    //             setDateOfVisit(response.data.dateOfVisit);
    //             setBill(response.data.bill);
    //             setImageUrl(response.data.imageUrl);
    //             setMemo(response.data.memo)
    //         })
    //         .catch((error)=>{
    //             console.log(error);
    //         })
    // }

    const handleChange_hospitalName = (e)=>{
        e.preventDefault();
        setHospitalName(e.target.value);
    }

    const handleChange_dateOfVisit = (e)=>{
        e.preventDefault();
        setDateOfVisit(e.target.value);
    }
    const handleChange_bill = (e)=>{
        e.preventDefault();
        setHospitalName(e.target.value);
    }
    const handleChange_imageUrl = (e)=>{
        e.preventDefault();
        setHospitalName(e.target.value);
    }
    const handleChange_memo = (e)=>{
        e.preventDefault();
        setHospitalName(e.target.value);
    }

    const handleSubmit = async (e) => {
        e.preventDefault();

        await axios
            .post("/hospitalNotes", {
                hospitalName: hospitalName,
                dateOfVisit: dateOfVisit,
            })
            .then((response) => {
                console.log(response.data)
            })
            .catch((error) => {
                console.log(error);
            });
    }


    return (
        <div className="hospital-form-container">
            <div className="hospital-form-title">
            <h1>병원기록</h1>
            </div>
            <form onSubmit={handleSubmit}>
                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="date" className="form-label-date">날짜</label>
                        <input
                            id="dateOfVisit"
                            type="date"
                            value={dateOfVisit}
                            onChange={(event) => setDateOfVisit(event.target.value)}
                        />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="symptoms" className="form-label-symptoms">병원명</label>
                        <textarea
                            id="hospitalName"
                            type="string"
                            value={hospitalName}
                            onChange={(event) => setHospitalName(event.target.value)}
                        />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="bill" className="form-label-bill">비용</label>
                        <input
                            id="bill"
                            type="number"
                            value={bill}
                            onChange={(event) => setBill(event.target.value)}
                        />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="memo" className="form-label-memo">메모</label>
                        <textarea
                            id="memo"
                            rows="3"
                            value={memo}
                            onChange={(event) => setMemo(event.target.value)}
                        />
                    </div>
                </div>

                <div>
                    <form onSubmit={handleSubmit}>
                        <p>username<input type="text" required={true} value={hospitalName} onChange={handleChange_hospitalName}></input></p>
                        <p>password<input type="text" required={true} value={dateOfVisit} onChange={handleChange_dateOfVisit}></input></p>
                        <button type="submit">수정</button>
                    </form>
                </div>
            </form>
        </div>
    );
}

export default HospitalForm;
