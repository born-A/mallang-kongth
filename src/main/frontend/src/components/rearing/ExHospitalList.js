import React, {useEffect, useState} from 'react';
import axios from 'axios';
import './HospitalRecordsPage.css';
import {
    Link, Switch, Route, BrowserRouter
} from 'react-router-dom';
function NoticeMain() {
    // 리스트 객체
    const [hospitalNoteList, setHospitalNoteList] = useState([{
        id: '',
        pet: '',
        hospitalName: '',
        dateOfVisit: '',
        bill : '',
        memos : '',
        imageUrl: '',
    }]);

    // 백엔드단에서 리스트 객체를 가져오는 부분

    useEffect(() => {
        axios.get("/hospitalNotes")
            .then(res => setHospitalNoteList(res.data.hospitalNoteList))
            .catch(error => console.log(error))

    }, []);

    return (
        <div>

            <div className="hospitalNoteList">
                <table className="noticeTable">
                    <thead>
                    <tr>
                        <th className="col-lg-2">
                            병원명
                        </th>
                        <th className="col-lg-8">
                            방문일자
                        </th>
                        <th className="col-lg-2">
                            병원비
                        </th>
                        <th className="col-lg-2">
                            메모
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    {/* list.map을 사용해서 반복문 구현 */}
                    {hospitalNoteList.map((hospitalNote, id) => {
                        return (
                            <tr key={hospitalNote.id}>
                                <td>{hospitalNote.hospitalName}</td>
                                <td>{hospitalNote.dateOfVisit}</td>
                                <td>{hospitalNote.bill}</td>
                                <td>{hospitalNote.memos}</td>
                                <td>{hospitalNote.imageUrl}</td>
                            </tr>
                        )
                    })}

                    </tbody>
                </table>
            </div>
        </div>
    );
}
export default NoticeMain;