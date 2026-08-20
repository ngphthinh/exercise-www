<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }

        .form-container {
            border: 1px solid #0dcaf0;
            padding: 15px;
            max-width: 1000px;
            margin: auto;
        }

        .form-label {
            font-size: 14px;
        }

        .form-control,
        .form-select {
            font-size: 14px;
        }

        .section-title {
            font-weight: 600;
            margin-top: 10px;
            margin-bottom: 8px;
        }
    </style>
</head>

<body>

<div class="container-fluid mt-2">
    <div class="form-container">

        <h4 class="text-center mb-3">
            Student Registration Form
        </h4>

        <form action="${pageContext.request.contextPath}/student" method="post">

            <!-- First Name / Last Name -->
            <div class="row g-3">
                <div class="col-md-6">
                    <label class="form-label">First Name</label>
                    <input type="text"
                           name="first-name" value="Phước Thịnh"
                           class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Last Name</label>
                    <input type="text"
                           value="Nguyễn"
                           name="last-name"
                           class="form-control">
                </div>
            </div>

            <!-- Date of Birth -->
            <div class="mt-2">
                <label class="form-label">Date of Birth</label>
                <input type="date"
                       name="dob"
                       class="form-control" value="2005-07-10">
            </div>

            <!-- Email / Mobile -->
            <div class="row g-3 mt-0">
                <div class="col-md-6">
                    <label class="form-label">Email</label>
                    <input type="email"
                           name="email" value="nguyenphuocthinh020@gmail.com"
                           class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Mobile</label>
                    <input type="tel"
                           name="mobile" value="0338687106"
                           class="form-control">
                </div>
            </div>

            <!-- Gender -->
            <div class="mt-2">
                <label class="form-label d-block">Gender</label>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           checked
                           type="radio"
                           name="gender"
                           value="Male"
                           id="male">
                    <label class="form-check-label" for="male">
                        Male
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="radio"
                           name="gender"
                           value="Female"
                           id="female">
                    <label class="form-check-label" for="female">
                        Female
                    </label>
                </div>
            </div>

            <!-- Address -->
            <div class="mt-2">
                <label class="form-label">Address</label>
                <textarea name="address"
                          class="form-control"
                          rows="2">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard</textarea>
            </div>

            <!-- City / Pin Code -->
            <div class="row g-3 mt-0">
                <div class="col-md-6">
                    <label class="form-label">City</label>
                    <input type="text"
                           name="city"
                           value="TPHCM"
                           class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Pin Code</label>
                    <input type="text"
                           name="pin-code"
                           class="form-control">
                </div>
            </div>

            <!-- State / Country -->
            <div class="row g-3 mt-0">
                <div class="col-md-6">
                    <label class="form-label">State</label>
                    <input type="text"
                           name="state"
                           value="Gò Vấp"
                           class="form-control">
                </div>

                <div class="col-md-6">
                    <label class="form-label">Country</label>
                    <select name="country" class="form-select">
                        <option value="India">India</option>
                        <option selected value="Vietnam">Vietnam</option>
                        <option value="USA">USA</option>
                        <option value="Japan">Japan</option>
                        <option value="Korea">Korea</option>
                    </select>
                </div>
            </div>

            <!-- Hobbies -->
            <div class="mt-2">
                <label class="form-label d-block">Hobbies</label>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="checkbox"
                           name="hobbies" checked
                           value="Drawing"
                           id="drawing">
                    <label class="form-check-label" for="drawing">
                        Drawing
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="checkbox"
                           name="hobbies" checked
                           value="Singing"
                           id="singing">
                    <label class="form-check-label" for="singing">
                        Singing
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="checkbox"
                           name="hobbies"
                           value="Dancing"
                           id="dancing">
                    <label class="form-check-label" for="dancing">
                        Dancing
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="checkbox"
                           name="hobbies"
                           value="Sketching"
                           id="sketching">
                    <label class="form-check-label" for="sketching">
                        Sketching
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="checkbox"
                           name="hobbies"
                           value="Others" checked
                           id="others">
                    <label class="form-check-label" for="others">
                        Others
                    </label>
                </div>
            </div>

            <!-- Qualification -->
            <div class="section-title">
                Qualification
            </div>

            <div class="table-responsive">
                <table class="table table-bordered align-middle mb-2">

                    <thead>
                    <tr>
                        <th style="width: 7%">Sl.No</th>
                        <th style="width: 13%">Examination</th>
                        <th>Board</th>
                        <th>Percentage</th>
                        <th>Year of Passing</th>
                    </tr>
                    </thead>

                    <tbody>

                    <tr>
                        <td>1</td>
                        <td>Class X</td>

                        <td>
                            <input type="text"
                                   name="board-X"
                                   class="form-control">
                        </td>

                        <td>
                            <input type="text"
                                   name="percentage-X"
                                   class="form-control">
                        </td>

                        <td>
                            <input type="text"
                                   name="year-X"
                                   class="form-control">
                        </td>
                    </tr>

                    <tr>
                        <td>2</td>
                        <td>Class XII</td>

                        <td>
                            <input type="text"
                                   name="board-XII"
                                   class="form-control">
                        </td>

                        <td>
                            <input type="text"
                                   name="percentage-XII"
                                   class="form-control">
                        </td>

                        <td>
                            <input type="text"
                                   name="year-XII"
                                   class="form-control">
                        </td>
                    </tr>

                    </tbody>
                </table>
            </div>

            <!-- Course -->
            <div class="mt-1">
                <label class="form-label d-block">
                    Course applies for
                </label>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="radio"
                           name="course" checked
                           value="BCA"
                           id="bca">
                    <label class="form-check-label" for="bca">
                        BCA
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="radio"
                           name="course"
                           value="B.Com"
                           id="bcom">
                    <label class="form-check-label" for="bcom">
                        B.Com
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="radio"
                           name="course"
                           value="B.Sc"
                           id="bsc">
                    <label class="form-check-label" for="bsc">
                        B.Sc
                    </label>
                </div>

                <div class="form-check form-check-inline">
                    <input class="form-check-input"
                           type="radio"
                           name="course"
                           value="B.A"
                           id="ba">
                    <label class="form-check-label" for="ba">
                        B.A
                    </label>
                </div>
            </div>

            <!-- Buttons -->
            <div class="text-center mt-3">
                <button type="submit"
                        class="btn btn-primary btn-sm">
                    Submit
                </button>

                <button type="button" onclick="resetForm()"
                        class="btn btn-secondary btn-sm">
                    Reset
                </button>
            </div>

        </form>

    </div>
</div>

<script>
    function resetForm() {
        const form = document.querySelector("form");

        form.querySelectorAll("input").forEach(input => {
            if (input.type === "checkbox" || input.type === "radio") {
                input.checked = false;
            } else {
                input.value = "";
            }
        });


        form.querySelectorAll("textarea").forEach(textarea => {
            textarea.value = "";
        });

        form.querySelectorAll("select").forEach(select => {
            select.selectedIndex = 0;
        });
    }
</script>
</body>
</html>