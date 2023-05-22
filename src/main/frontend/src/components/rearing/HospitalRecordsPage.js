import React, { useState } from 'react';
import HospitalForm from './HospitalForm';
import './HospitalRecordsPage.css';

function HospitalRecordsPage() {
    const [records, setRecords] = useState([]);

    const handleRecordSubmit = (record) => {
        setRecords([...records, record]);
    };

    const handleClickRecord = () => {
        setRecordFormVisible(true);
    };

    const handleCancelRecord = () => {
        setRecordFormVisible(false);
    };

    const [recordFormVisible, setRecordFormVisible] = useState(false);

    return (
        <div className="background">
            <div className="box">
                <div className="header">
                    <h1>말랑콩떡</h1>
                </div>
                {recordFormVisible ? (
                    <div>
                        <h2>기록하기</h2>
                        <HospitalForm onRecordSubmit={handleRecordSubmit} />
                        <button onClick={handleCancelRecord}>취소</button>
                    </div>
                ) : (
                    <div>
                        <h2>입력된 병원 기록</h2>
                        <ul>
                            {records.length > 0 ? (
                                records.map((record, index) => (
                                    <li key={index}>
                                        <p>날짜: {record.date}</p>
                                        <p>증상: {record.symptoms}</p>
                                        <p>비용: {record.cost}</p>
                                        <p>메모: {record.note}</p>
                                    </li>
                                ))
                            ) : (
                                <li>입력된 병원 기록이 없습니다.</li>
                            )}
                        </ul>
                        <div className="center">
                            <button className="yellow-button" onClick={handleClickRecord}>기록하기</button>
                        </div>
                    </div>
                )}
            </div>
        </div>
    );
}

export default HospitalRecordsPage;
