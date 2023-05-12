import React, { useState } from 'react';
import './HospitalForm.css';

function HospitalRecordForm(props) {
    const [date, setDate] = useState('');
    const [symptoms, setSymptoms] = useState('');
    const [cost, setCost] = useState('');
    const [note, setNote] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const newRecord = {
            date: date,
            symptoms: symptoms,
            cost: cost,
            note: note,
        };
        props.onAddRecord(newRecord);
        setDate('');
        setSymptoms('');
        setCost('');
        setNote('');
    };

    return (
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
                <button type="submit" className="form-button-submit">기록하기</button>
            </div>
        </form>
    );
}

export default HospitalRecordForm;
