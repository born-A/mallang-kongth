// import React, {useEffect, useState} from 'react';
// import './HospitalForm.css';
//
// import axios, { AxiosResponse } from 'axios';
// import apiAxios from "../../apiAxios";
//
// function HospitalForm({ onRecordSubmit }) {
//     const baseUrl = "http://localhost:8080";
//
//     const [petList, setPetList] = useState([]);
//     const [hospitalFormList, setHospitalForm] = useState([]);
//
//
//
//     async function getFormDto(){
//         await axios
//             .get("/hospitalNotes/new")
//             .then((response) => {
//                 console.log(response.data);
//                 setPetList(response.data.petList);
//                 setHospitalForm(response.data.hospitalFormList);
//             })
//             .catch((error)=>{
//                 console.log(error);
//             })
//     }
//
//     const handleChange_petList = (e)=>{
//         e.preventDefault();
//         setPetList(e.target.value);
//     }
//
//     const handleChange_hospitalForm = (e)=>{
//         e.preventDefault();
//         setHospitalForm(e.target.value);
//     }
//
//
//
//     const handleSubmit = async (e) => {
//         e.preventDefault();
//
//         await axios
//             .post("/hospitalNotes", {
//                 hospitalName: hospitalName,
//                 dateOfVisit: dateOfVisit,
//             })
//             .then((response) => {
//                 console.log(response.data)
//             })
//             .catch((error) => {
//                 console.log(error);
//             });
//     }
//
//
//     return (
//         <div className="hospital-form-container">
//             <div className="hospital-form-title">
//             <h1>병원기록</h1>
//             </div>
//             <form onSubmit={handleSubmit}>
//                 <div className="form-row">
//                     <div className="form-field">
//                         <label htmlFor="date" className="form-label-date">날짜</label>
//                         <input
//                             id="dateOfVisit"
//                             type="date"
//                             value={dateOfVisit}
//                             onChange={(event) => setDateOfVisit(event.target.value)}
//                         />
//                     </div>
//                 </div>
//
//                 <div className="form-row">
//                     <div className="form-field">
//                         <label htmlFor="symptoms" className="form-label-symptoms">병원명</label>
//                         <textarea
//                             id="hospitalName"
//                             type="string"
//                             value={hospitalName}
//                             onChange={(event) => setHospitalName(event.target.value)}
//                         />
//                     </div>
//                 </div>
//
//                 <div className="form-row">
//                     <div className="form-field">
//                         <label htmlFor="bill" className="form-label-bill">비용</label>
//                         <input
//                             id="bill"
//                             type="number"
//                             value={bill}
//                             onChange={(event) => setBill(event.target.value)}
//                         />
//                     </div>
//                 </div>
//
//                 <div className="form-row">
//                     <div className="form-field">
//                         <label htmlFor="memo" className="form-label-memo">메모</label>
//                         <textarea
//                             id="memo"
//                             rows="3"
//                             value={memo}
//                             onChange={(event) => setMemo(event.target.value)}
//                         />
//                     </div>
//                 </div>
//
//                 <div>
//                     <form onSubmit={handleSubmit}>
//                         <p>username<input type="text" required={true} value={hospitalName} onChange={handleChange_hospitalName}></input></p>
//                         <p>password<input type="text" required={true} value={dateOfVisit} onChange={handleChange_dateOfVisit}></input></p>
//                         <button type="submit">수정</button>
//                     </form>
//                 </div>
//             </form>
//         </div>
//     );
// }
//
// export default HospitalForm;
