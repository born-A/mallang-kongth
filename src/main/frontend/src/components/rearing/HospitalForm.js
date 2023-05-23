import React, { useState } from 'react';
import './HospitalForm.css';

import axios, { AxiosResponse } from 'axios';
import apiAxios from "../../apiAxios";

function HospitalForm({ onRecordSubmit }) {

    const [date, setDate] = useState('');
    const [symptoms, setSymptoms] = useState('');
    const [cost, setCost] = useState('');
    const [note, setNote] = useState('');

    const handleSubmit = () => {
        const record = {
            date: date,
            symptoms: symptoms,
            cost: cost,
            note: note
        };

        onRecordSubmit(record);
    };


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
                            id="date"
                            type="date"
                            value={date}
                            onChange={(event) => setDate(event.target.value)}
                        />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="symptoms" className="form-label-symptoms">증상</label>
                        <textarea
                            id="symptoms"
                            rows="3"
                            value={symptoms}
                            onChange={(event) => setSymptoms(event.target.value)}
                        />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="cost" className="form-label-cost">비용</label>
                        <input
                            id="cost"
                            type="number"
                            value={cost}
                            onChange={(event) => setCost(event.target.value)}
                        />
                    </div>
                </div>

                <div className="form-row">
                    <div className="form-field">
                        <label htmlFor="note" className="form-label-note">메모</label>
                        <textarea
                            id="note"
                            rows="3"
                            value={note}
                            onChange={(event) => setNote(event.target.value)}
                        />
                    </div>
                </div>

                <div className="submit-button">
                    <button type="submit" className="form-button-submit">
                        기록하기
                    </button>
                </div>
            </form>
        </div>
    );
}

export default HospitalForm;
