import React, { useState } from 'react';

function PetJournalForm(props) {
    const [foodAmount, setFoodAmount] = useState('');
    const [waterAmount, setWaterAmount] = useState('');

    const submitHandler = (event) => {
        event.preventDefault();
        const newEntry = {
            food: foodAmount,
            water: waterAmount,
            date: new Date(),
        };
        props.onAddEntry(newEntry);
        setFoodAmount('');
        setWaterAmount('');
    };

    return (
        <form onSubmit={submitHandler}>
            <label>
               배식량:
                <input
                    type="text"
                    value={foodAmount}
                    onChange={(event) => setFoodAmount(event.target.value)}
                />
            </label>
            <label>
                급수량:
                <input
                    type="text"
                    value={waterAmount}
                    onChange={(event) => setWaterAmount(event.target.value)}
                />
            </label>
            <button type="submit">입력</button>
        </form>
    );
}

export default PetJournalForm;
