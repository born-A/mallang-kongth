import React, { useState } from 'react';
import './WaterAmountInput.css';

function WaterAmountInput({ onAmountSubmit }) {
    const [foodAmount, setWaterAmount] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onAmountSubmit(foodAmount);
    };

    return (
        <div className="water-amount-input">
            <h2>급수량 입력</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={foodAmount}
                    onChange={(e) => setWaterAmount(e.target.value)}
                    required
                />
                <button type="submit">입력</button>
            </form>
        </div>
    );
}

export default WaterAmountInput;
