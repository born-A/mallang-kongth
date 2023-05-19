import React, { useState } from 'react';
import './WalkAmountInput.css';

function WalkAmountInput({ onAmountSubmit }) {
    const [walkAmount, setWalkAmount] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        onAmountSubmit(walkAmount);
    };

    return (
        <div className="walk-amount-input">
            <h2>산책량 입력</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={walkAmount}
                    onChange={(e) => setWalkAmount(e.target.value)}
                    required
                />
                <button type="submit">입력</button>
            </form>
        </div>
    );
}

export default WalkAmountInput;
