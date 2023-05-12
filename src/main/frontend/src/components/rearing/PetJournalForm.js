import React, { useState } from 'react';
import './PetJournalForm.css';

function PetJournalForm(props) {
    const [foodAmount, setFoodAmount] = useState('');
    const [waterAmount, setWaterAmount] = useState('');
    const [walkAmount, setWalkAmount] = useState('');
    const [pooAmount, setPooAmount] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        const newEntry = {
            food: foodAmount,
            water: waterAmount,
            walk: walkAmount,
            poo: pooAmount,
            date: new Date(),
        };
        props.onAddEntry(newEntry);
        setFoodAmount('');
        setWaterAmount('');
        setWalkAmount('');
        setPooAmount('');
    };

    return (
        <form onSubmit={handleSubmit}>
            <div className="form-row">
                <div className="form-field" style={{ marginBottom: "10px" }}>
                    <label htmlFor="food-amount" style={{ marginTop: "100px" }}>
                        배식량
                    </label>
                    <input
                        id="food-amount"
                        type="number"
                        value={foodAmount}
                        onChange={(event) => setFoodAmount(event.target.value)}
                    />
                </div>
            </div>

            <div className="form-row">
                <div className="form-field">
                    <label htmlFor="water-amount" style={{ marginTop: "100px" }}>
                        급수량
                    </label>
                    <input
                        id="water-amount"
                        type="number"
                        value={waterAmount}
                        onChange={(event) => setWaterAmount(event.target.value)}
                    />
                </div>
            </div>

            <div className="form-row">
                <div className="form-field">
                    <label htmlFor="walk-amount" style={{ marginTop: "100px" }}>
                        산책
                    </label>
                    <input
                        id="walk-amount"
                        type="number"
                        value={walkAmount}
                        onChange={(event) => setWalkAmount(event.target.value)}
                    />
                </div>
            </div>

            <div className="form-row">
                <div className="form-field">
                    <label htmlFor="poo-amount" style={{ marginTop: "100px" }}>
                        배변
                    </label>
                    <input
                        id="poo-amount"
                        type="number"
                        value={pooAmount}
                        onChange={(event) => setPooAmount(event.target.value)}
                    />
                </div>
            </div>

            <div className="Rectangle-55" style={{ display: "inline-flex", justifyContent: "flex-start", alignItems: "center" }}>
                <span>추가하기</span>
                <label htmlFor="hospital" style={{ marginTop: "50px", alignItems: "center", justifyContent: "flex-start" }}>
                    병원기록
                </label>
            </div>





            <button type="submit">입력완료</button>
        </form>
    );
}

export default PetJournalForm;
