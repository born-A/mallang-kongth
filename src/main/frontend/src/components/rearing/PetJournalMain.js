import React, { useState } from 'react';
import './PetJournalMain.css';
import FoodAmountInput from './FoodAmountInput';
import WaterAmountInput from './WaterAmountInput';
import WalkCountInput from './WalkCountInput';
import BathroomAmountInput from './BathroomAmountInput';
import HospitalForm from './HospitalForm';
import MemoForm from './Memo'; // MemoForm 컴포넌트를 import 합니다.

function PetJournalMain() {
    const [foodAmount, setFoodAmount] = useState('');
    const [waterAmount, setWaterAmount] = useState('');
    const [walkCount, setWalkCount] = useState('');
    const [bathroomCount, setBathroomCount] = useState('');
    const [showFoodAmountInput, setShowFoodAmountInput] = useState(false);
    const [showWaterAmountInput, setShowWaterAmountInput] = useState(false);
    const [showWalkCountInput, setShowWalkCountInput] = useState(false);
    const [showBathroomCountInput, setShowBathroomCountInput] = useState(false);
    const [showHospitalRecordInput, setShowHospitalRecordInput] = useState(false);
    const [showMemoRecordInput, setShowMemoRecordInput] = useState(false); // 메모 기록을 표시할 상태를 추가합니다.
    const [hospitalRecord, setHospitalRecord] = useState('');
    const [memoRecord, setMemoRecord] = useState(''); // 메모 기록을 저장할 상태를 추가합니다.

    const handleAmountSubmit = (amount, type) => {
        switch (type) {
            case 'food':
                setFoodAmount(amount);
                setShowFoodAmountInput(false);
                break;
            case 'water':
                setWaterAmount(amount);
                setShowWaterAmountInput(false);
                break;
            case 'walk':
                setWalkCount(amount);
                setShowWalkCountInput(false);
                break;
            case 'bathroom':
                setBathroomCount(amount);
                setShowBathroomCountInput(false);
                break;
            default:
                break;
        }
    };

    const handleInputClick = (type) => {
        switch (type) {
            case 'food':
                setShowFoodAmountInput(true);
                break;
            case 'water':
                setShowWaterAmountInput(true);
                break;
            case 'walk':
                setShowWalkCountInput(true);
                break;
            case 'bathroom':
                setShowBathroomCountInput(true);
                break;
            case 'hospital':
                setShowHospitalRecordInput(true);
                break;
            case 'memo':
                setShowMemoRecordInput(true);
                break;
            default:
                break;
        }
    };

    const handleRecordSubmit = (record) => {
        const formattedRecord = `날짜: ${record.date}, 증상: ${record.symptoms}, 비용: ${record.cost}, 메모: ${record.note}`;
        setHospitalRecord(formattedRecord);
        setShowHospitalRecordInput(false);
    };

    const handleMemoSubmit = (memo) => {
        setMemoRecord(memo);
        setShowMemoRecordInput(false);
    };

    return (
        <div className="background">
            <div className="box">
                {/* 헤더부분 */}
                <div className="header">
                    <h1>말랑콩떡</h1>
                </div>

                <div className="pet-journal-container">
                    <h1>육아수첩</h1>
                    <div className="form-group">
                        <div className="input-wrapper">
                            <div className="input-container food-amount">
                                <p className="input-label" onClick={() => handleInputClick('food')}>
                                    배식량 {foodAmount || ''}
                                </p>
                                {showFoodAmountInput ? (
                                    <FoodAmountInput onAmountSubmit={(amount) => handleAmountSubmit(amount, 'food')} />
                                ) : null}
                            </div>
                        </div>
                        <div className="input-wrapper">
                            <div className="input-container water-amount">
                                <p className="input-label" onClick={() => handleInputClick('water')}>
                                    급수량 {waterAmount || ''}
                                </p>
                                {showWaterAmountInput ? (
                                    <WaterAmountInput onAmountSubmit={(amount) => handleAmountSubmit(amount, 'water')} />
                                ) : null}
                            </div>
                        </div>
                    </div>
                    <div className="form-group">
                        <div className="input-wrapper">
                            <div className="input-container walk-amount">
                                <p className="input-label" onClick={() => handleInputClick('walk')}>
                                    산책 횟수 {walkCount || ''}
                                </p>
                                {showWalkCountInput ? (
                                    <WalkCountInput onAmountSubmit={(amount) => handleAmountSubmit(amount, 'walk')} />
                                ) : null}
                            </div>
                        </div>
                        <div className="input-wrapper">
                            <div className="input-container bathroom-amount">
                                <p className="input-label" onClick={() => handleInputClick('bathroom')}>
                                    배변 횟수 {bathroomCount || ''}
                                </p>
                                {showBathroomCountInput ? (
                                    <BathroomAmountInput onAmountSubmit={(amount) => handleAmountSubmit(amount, 'bathroom')} />
                                ) : null}
                            </div>
                        </div>
                    </div>
                    <div className="form-group">
                        <div className="input-wrapper horizontal-box">
                            <div className="input-container hospital-record">
                                <p className="input-label" onClick={() => handleInputClick('hospital')}>
                                    병원 기록
                                </p>
                                {showHospitalRecordInput ? (
                                    <HospitalForm onRecordSubmit={handleRecordSubmit} />
                                ) : null}
                                {hospitalRecord && !showHospitalRecordInput ? (
                                    <div className="hospital-record-box">
                                        <p className="record-text">{hospitalRecord}</p>
                                    </div>
                                ) : null}
                            </div>
                        </div>
                        <div className="input-wrapper horizontal-box">
                            <div className="input-container memo-record">
                                <p className="input-label" onClick={() => handleInputClick('memo')}>
                                    메모 기록
                                </p>
                                {showMemoRecordInput ? (
                                    <MemoForm onMemoSubmit={handleMemoSubmit} />
                                ) : null}
                                {memoRecord && !showMemoRecordInput ? (
                                    <div className="memo-record-box">
                                        <p className="record-text">{memoRecord}</p>
                                    </div>
                                ) : null}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

);
}

export default PetJournalMain;
