import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid'; // 월별 뷰 플러그인
import interactionPlugin from "@fullcalendar/interaction" // 클릭을 위해 필요

const Calendar = () => {
    const handleAddPlan = (e) => {
        alert('일정 클릭', e.dateStr);
    }

    const renderEventContent = (e) => {
        return(
            <>
                <b>{e.timeText}</b>
                <i>{e.event.title}</i>
            </>
    )}

  return (
        <FullCalendar
            defaultCalendar="dayGridMonth"
            plugins={[dayGridPlugin, interactionPlugin]}
            selectable={true}
            initialView='dayGridMonth'
            dateClick={handleAddPlan}
            eventContent={renderEventContent}
        >
        </FullCalendar>
  )
}

export default Calendar