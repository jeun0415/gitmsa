-- 책 p214~

-- 1. Employees와 Departments 테이블에 저장된 행의 개수를 출력하세요.
select count(*) '행 개수'
from employees
union all
select count(*)
from departments;

-- 2. Employees 테이블에 대한 employee_id, last_name, job_id, hire_date를 출력하세요.
select employee_id, last_name, job_id, hire_date
from employees;

select employee_id, last_name, job_title, hire_date
from employees E
join jobs J on E.job_id = J.job_id;

-- 3. Employees 테이블에서 salary가 12,000 이상인 직원의 last_name과 salary를 출력하세요.
select last_name, salary
from employees
where salary >= 12000
order by salary desc;

-- 4. 부서번호 (department_id)가 20 혹은 50인 직원의 last_name과 department_id를 last_name에 대하여 
-- 오름차순으로 출력하세요.
select E.last_name, E.department_id
from departments D, employees E
where D.department_id = E.department_id and E.department_id in (20, 50)
order by E.last_name;

select E.last_name, D.department_name
from departments D, employees E
where D.department_id = E.department_id and E.department_id in (20, 50)
order by E.last_name;

-- 5. last_name의 세 번째에 a가 들어가는 직원의 last_name을 출력하세요.
select last_name
from employees
where last_name like '__a%'
order by last_name;

-- 6. 같은 일(job)을 하는 사람의 수를 세어 출력하세요.
select job_id, count(*) 
from employees
group by job_id
having count(job_id) >= 2;

-- 7. 급여(salary)의 최대값과 최소값의 차이를 구하세요.
select max(salary)-min(salary)
from employees;

-- 7-1. 직업별 최대 급여와 최소 급여의 차이
select job_title, max_salary-min_salary
from jobs
order by job_title;

-- 8. Toronto(city)에서 일하는 직원의 last_name, job, department_id, department_name을 출력하세요.
select E.last_name, J.job_title, D.department_id, D.department_name
from departments D, employees E, jobs J, locations L
where D.department_id = E.department_id and E.job_id = J.job_id and
		D.location_id = L.location_id and L.city = 'Toronto'
order by last_name;



-- 1. 성(last name)이 Matos와 Taylor인 직원의 성, 직무 ID(job_id), 
-- 시작 날짜(start date)를 출력하는 보고서를 작성하세요. 쿼리를 시작 날짜 기준 오름차순으로 정렬하세요.
select E.last_name, E.job_id, JH.start_date
from employees E, job_history JH
where E.job_id = JH.job_id and E.last_name in ('Matos', 'Taylor')
order by start_date;

-- 2. 1994년에 고용된 모든 직원의 성(last name)과 입사 날짜(hire date)를 출력하는 보고서가 인사부서에 필요합니다.
select last_name, hire_date
from employees
where date_format(hire_date, '%Y') = '1994'
order by hire_date;

select last_name, hire_date
from employees
where year(hire_date) = '1994'
order by hire_date;
 
-- 3. 직무가 영업 대표(sales representative) 또는 재고 사원(stock clerk)인 
-- 모든 직원의 성(last name), 직무(job), 급여(salary)를 출력하며, 급여가 $2,500, $3,500 또는 $7,000가 
-- 아닌 직원들을 포함하세요.
select distinct E.last_name, J.job_title, E.salary
from jobs J
join employees E on E.job_id = J.job_id
where J.job_title in ('Sales Representative', 'Stock Clerk') 
		or E.salary not in (2500, 3500, 7000)
order by salary;
 
-- 4. 매니저 수를 나열하지 않고 구하세요. 열 이름을 '매니저 수(Number of Managers)'로 표시하세요.
select count(distinct manager_id) '매니저 수(Number of Managers)'
from employees;
 
-- 5. 매니저의 번호(manager number)와 해당 매니저 밑에서 가장 낮은 급여를 받는 직원의 급여를 출력하는 
-- 보고서를 작성하세요. 매니저가 알려지지 않은 경우와 최소 급여가 $6,000 이하인 그룹은 제외하세요. 
-- 출력 값을 급여 내림차순으로 정렬하세요.
select E1.salary
from employees E1, employees E2
where E1.salary < E2.salary
group by E1.manager_id
having E1.manager_id is not null;???

-- 6. 직원의 성(last name)과 직원 번호(employee number), 그리고 그들의 매니저의 성(last name)과 
-- 매니저 번호(manager number)를 함께 출력하는 보고서를 작성하세요. 
-- 열 이름은 각각 'Employee', 'Emp#', 'Manager', 'Mgr#'로 표시하세요.
select last_name 'Employee', employee_id 'Emp#', manager_id 'Manager', manager_id 'Mgr#'
from employees;

-- 7. 주어진 직원(6번 문제)과 같은 부서에서 일하는 모든 직원의 성(last name), 
-- 부서 번호(department number)를 출력하는 보고서를 인사부서에 작성하세요.
 
-- 8. 임원 부서(Executive department)에 있는 모든 직원의 부서 번호(department number), 
-- 성(last name), 직무 ID(job_id)를 출력하는 보고서를 작성하세요.
select D.department_id, E.last_name, E.job_id
from employees E
join departments D on D.department_id = E.department_id
where D.department_name = 'Executive department';???

-- 9. King에게 보고하는 모든 직원의 성(last name)과 급여(salary)를 출력하는 보고서를 작성하세요.
select last_name, salary
from employees
where manager_id = (select employee_id from employees where last_name = 'King');
 
-- 10. 'ST_CLERK' 직무 ID를 포함하지 않는 부서의 부서 ID 목록이 인사부서에 필요합니다.
select department_id
from departments
where;


-- 문자열 처리 문제
-- 1. 사원의 이름이 8자 이상인 사원의 정보를 출력하세요.
select *
from employees E
group by employee_id
having (length(first_name)+length(last_name)) >= 8;

-- 2. 이름의 첫 글자가 대문자인 사원의 정보를 출력하세요.???
select *
from employees
where first_name like upper;

-- 3. 사원의 성의 2번째 문자가 'c'인 사원의 이름과 이름의 길이를 출력하세요.
select first_name, last_name, length(first_name)+length(last_name) '이름의 길이'
from employees
where last_name like '_c%'
order by last_name;

-- 4. 주소 중 거리의 이름의 문자가 길이가 최소인 지역(locations)을 출력하세요.
select *, length(street_address)
from locations
group by location_id
having min(select length(street_address) from locations;);

-- 5. 이름이 'A','J', 'M'으로 시작하는 사원의 이름과 이름의 길이를 출력하세요.

-- Date 타입 처리 문제
-- 1. 1987년에 입사한 사원의 이름을 출력하세요.
-- 2. 사원의 이름, 입사년도, 근무년수를 출력하세요.
-- 3. '1987-06-01'과 '1987-07-30'사이에 입사한 사원의 이름과 입사일을 출력하세요.
-- 4. 6월에 입사한 사원의 이름과 성을 출력하세요.
-- 5. 부서별, 연도별 입사한 사원의 수를 구하세요. 